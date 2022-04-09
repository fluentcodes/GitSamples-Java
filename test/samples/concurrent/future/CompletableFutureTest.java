package samples.concurrent.future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.*;

public class CompletableFutureTest {

    private ExecutorService executor;

    @Before
    public void setup() throws Exception {
        System.out.println("Testing thread: " + Thread.currentThread().getId());
        executor = Executors.newFixedThreadPool(4);
    }

    @After
    public void teardown() throws Exception {
        executor.shutdown();
    }

    @Test
    public void simpleFuture() {
        try {
            final Future<String> future = executor.submit(() -> RemoteProvider.httpGet());
            Thread.sleep(800);
            final Instant start = Instant.now();
            final String body = future.get();  // future.get() is blocking
//            final String body = future.get(200L, TimeUnit.MILLISECONDS);
            RemoteProvider.printWithElapsedTime(start, body);
        } catch (final Exception e) {
            System.err.println(e.toString());
        }
    }

    @Test
    public void testCompletableFutureBlocking() throws Exception {
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ba";
        }, executor);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final Instant start = Instant.now();
        final String body = future.get();
        RemoteProvider.printWithElapsedTime(start, body);
    }

    @Test
    public void testCompletableFutureWithTimeout() throws Exception {
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet(), executor);
        try {
            final Instant start = Instant.now();
            final String body = future.get(200L, TimeUnit.MILLISECONDS);
            RemoteProvider.printWithElapsedTime(start, body);
        } catch (final TimeoutException e) {
            System.err.println("Timeout!");
        }
    }

    @Test
    public void testCompletableFutureFallback() throws Exception {
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet(), executor);
        Thread.sleep(100L);
        final Instant start = Instant.now();
        final String body = future.getNow("Request timed out");
        RemoteProvider.printWithElapsedTime(start, body);
    }

    @Test(expected = ExecutionException.class)
    public void testFutureExceptionUncaught() throws Exception {
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet("x"), executor);
        final Instant start = Instant.now();
        final String body = future.get();
        RemoteProvider.printWithElapsedTime(start, body);
    }

    @Test
    public void testFutureException() throws Exception {
        final CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> RemoteProvider.httpGet("x"), executor)
                .exceptionally(ex -> "async exception caught " + ex.getMessage() + ": " + ex.getCause().getMessage());
        final Instant start = Instant.now();
        final String body = future.get();
        RemoteProvider.printWithElapsedTime(start, body);
    }

    @Test
    public void testWhenComplete() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture
                .supplyAsync(() -> RemoteProvider.httpGet(), executor)
//                .exceptionally(ex -> "async exception caught " + ex.getMessage() + ": " + ex.getCause().getMessage())
                .whenComplete((body, ex) -> {
                    if (ex != null) {
                        System.err.println("completed with exception " + ex.getMessage());
                    } else {
                        RemoteProvider.printWithElapsedTime(start, body);
                    }
                    doneSignal.countDown();
                });

        doneSignal.await();
    }


    @Test
    public void testCompletableFutureWithAcceptConsumer() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture
                .supplyAsync(() -> RemoteProvider.httpGet(), executor)
                .exceptionally(ex -> "async exception caught " + ex.getMessage() + ": " + ex.getCause().getMessage())
                .thenAccept(body -> {
                    RemoteProvider.printWithElapsedTime(start, body);
                })
                .whenComplete((r, e) -> doneSignal.countDown());

        doneSignal.await();
    }

    @Test
    public void testCompletableFutureWithAsyncAcceptConsumer() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture
                .supplyAsync(() -> RemoteProvider.httpGet(), executor)
                .thenAcceptAsync(body -> {
                    RemoteProvider.printWithElapsedTime(start, body);
                })
                .whenComplete((r, e) -> doneSignal.countDown());

        doneSignal.await();
    }

    @Test
    public void testCompletableFutureJoined() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture
                .supplyAsync(() -> RemoteProvider.httpGet(), executor)
                .thenApply(RemoteProvider::extractHead)
                .thenAccept(head -> {
                    RemoteProvider.printWithElapsedTime(start, head);
                })
                .whenComplete((r, e) -> doneSignal.countDown());

        doneSignal.await();
    }

    @Test
    public void testCompletableFutureAsyncJoined() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture
                .supplyAsync(() -> RemoteProvider.httpGet(), executor)
                .thenApplyAsync(RemoteProvider::extractHead)
                .thenAcceptAsync(head -> {
                    RemoteProvider.printWithElapsedTime(start, head);
                })
                .whenComplete((r, e) -> doneSignal.countDown());


        doneSignal.await();
    }

    private CompletableFuture<String> extractHeadFuture(final String doc) {
        return CompletableFuture.supplyAsync(() -> RemoteProvider.extractHead(doc), executor);
    }

    @Test
    public void testCompletableFutureCompose() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet(), executor);
        future
                .thenCompose(this::extractHeadFuture)
                .thenAcceptAsync(head -> {
                    RemoteProvider.printWithElapsedTime(start, head);
                })
                .whenComplete((r, e) -> doneSignal.countDown());

        doneSignal.await();
    }

    @Test
    public void testCompletableFutureAcceptBoth() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet(), executor);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet("http://google.com"), executor);

        final CompletableFuture<String> remote1 = future1.thenCompose(this::extractHeadFuture);
        final CompletableFuture<String> remote2 = future2.thenCompose(this::extractHeadFuture);

        remote1.thenAcceptBothAsync(remote2,
            (h1, h2) -> {RemoteProvider.printWithElapsedTime(start, h1.concat(h2));})
            .whenComplete((r, e) -> doneSignal.countDown());

        doneSignal.await();
    }

    @Test
    public void testCompletableFutureCombine() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture<String>  future1 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet(), executor);
        CompletableFuture<String>  future2 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet("http://google.com"), executor);
        CompletableFuture<String>  future3 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet("https://duckduckgo.com"), executor);

        final CompletableFuture<String> remote1 = future1.thenCompose(this::extractHeadFuture);
        final CompletableFuture<String> remote2 = future2.thenCompose(this::extractHeadFuture);
        final CompletableFuture<String> remote3 = future3.thenCompose(this::extractHeadFuture);

        remote1.thenCombineAsync(remote2, String::concat).thenCombineAsync(remote3, String::concat)
                .thenAcceptAsync(all -> {
                    RemoteProvider.printWithElapsedTime(start, all);
                })
                .whenComplete((r, e) -> doneSignal.countDown());

        doneSignal.await();
    }

    @Test
    public void testCompletableFutureAcceptEither() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture<String>  future1 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet(), executor);
        CompletableFuture<String>  future2 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet("http://google.com"), executor);

        final CompletableFuture<String> remote1 = future1.thenCompose(this::extractHeadFuture);
        final CompletableFuture<String> remote2 = future2.thenCompose(this::extractHeadFuture);
        remote1.acceptEitherAsync(remote2, (head) -> {
            RemoteProvider.printWithElapsedTime(start, head);
        })
                .whenComplete((r, e) -> doneSignal.countDown());

        doneSignal.await();
    }

    @Test
    public void testCompletableFutureAllOf() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        CompletableFuture<String>  future1 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet(), executor);
        CompletableFuture<String>  future2 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet("http://google.com"), executor);
        CompletableFuture<String>  future3 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet("https://duckduckgo.com"), executor);


        final CompletableFuture<String> remote1 = future1.thenCompose(this::extractHeadFuture);
        final CompletableFuture<String> remote2 = future2.thenCompose(this::extractHeadFuture);
        final CompletableFuture<String> remote3 = future3.thenCompose(this::extractHeadFuture);
        CompletableFuture.allOf(remote1, remote2, remote3)
                .exceptionally(ex -> {
                    System.err.println(ex.getMessage());
                    return null;
                })
                .whenComplete((r, e) -> doneSignal.countDown());

        doneSignal.await();

//        final Instant start = Instant.now();
//        final String s = remote1.get();
//        printWithElapsedTime(start, s);
    }

    @Test
    public void testCompletableFutureAnyOf() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture<String>  future1 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet(), executor);
        CompletableFuture<String>  future2 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet("http://google.com"), executor);
        CompletableFuture<String>  future3 = CompletableFuture.supplyAsync(() -> RemoteProvider.httpGet("https://duckduckgo.com"), executor);

        final CompletableFuture<String> remote1 = future1.thenCompose(this::extractHeadFuture);
        final CompletableFuture<String> remote2 = future2.thenCompose(this::extractHeadFuture);
        final CompletableFuture<String> remote3 = future3.thenCompose(this::extractHeadFuture);

        CompletableFuture.anyOf(remote1, remote2, remote3)
                .exceptionally(ex -> {
                    System.err.println(ex.getMessage());
                    return null;
                })
                .thenAccept(head -> RemoteProvider.printWithElapsedTime(start, (String) head))
                .whenComplete((r, e) -> doneSignal.countDown());

        doneSignal.await();
    }

    @Test
    public void testCompose() throws Exception {
        final CompletableFuture<String> future1 = new CompletableFuture<>();
        final CompletableFuture<Integer> future2 = new CompletableFuture<>();
        final CompletableFuture<Integer> future3 = new CompletableFuture<>();

        future1
                .thenCombine(future2, (v1, v2) -> { System.out.println("combine[" + v1 + ", " + v2 + "]"); return v1 + v2.toString(); })
                .thenCombine(future3, (v1, v2) -> { System.out.println("combine[" + v1 + ", " + v2 + "]"); return v1 + v2.toString(); })
                .whenComplete((r, e) -> System.out.println("Result: " + r + ", Exception: " + e));

        future1.complete("value-");
//        future1.completeExceptionally(new IllegalStateException());
        future2.complete(47);
        future3.complete(11);
//        future3.completeExceptionally(new IllegalStateException());
    }

    @Test
    public void testCompletableFutureRunnable() throws Exception {
        final CountDownLatch doneSignal = new CountDownLatch(1);
        final Instant start = Instant.now();
        CompletableFuture.runAsync(() -> RemoteProvider.httpGet(), executor).whenComplete((r, e) -> doneSignal.countDown() );
        doneSignal.await();
        RemoteProvider.printWithElapsedTime(start, "runnable");
    }

    @Test
    public void testCompletionService() throws Exception {
        final CompletionService<String> cs = new ExecutorCompletionService<>(executor);
        cs.submit(() -> RemoteProvider.httpGet());
        cs.submit(() -> RemoteProvider.httpGet("http://google.com"));

        int nWaiting = 2;
        while (nWaiting > 0) {
            final Future<String> completed = cs.poll(10L, TimeUnit.MILLISECONDS);
            if (completed != null) {
                final Instant start = Instant.now();
                final String body = completed.get();
                RemoteProvider.printWithElapsedTime(start, body);
                --nWaiting;
            }
        }
    }


}
