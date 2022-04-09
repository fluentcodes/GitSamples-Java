package samples.concurrent.future;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class RemoteProvider {
  static final String REMOTE = "http://www.ecube.de";

  private RemoteProvider() {

  }
  static String httpGet(final String remote)  {
      System.out.println("httpGet thread: " + Thread.currentThread().getId());
      try {
          return readStream(new URL(remote).openStream(), 2000);
      } catch (final IOException e) {
          throw new IllegalStateException("get for url " + remote + " failed", e);
      }
  }

  static String httpGet() {
    return httpGet(REMOTE);
  }

  private static String readStream(final InputStream in, final int maxLen) throws IOException {
      final byte[] bytes = new byte[maxLen];
      int got = 0;
      int read;
      do {
//            System.out.println("readStream offset " + got + ", thread: " + Thread.currentThread().getId());
          read = in.read(bytes, got, maxLen - got);
          if (read > 0) {
              got += read;
          }
      }
      while (got < maxLen && read != -1);
      return new String(bytes, 0, got, Charset.forName("UTF-8"));
  }

  static String extractHead(final String doc) {
      System.out.println("extracting thread: " + Thread.currentThread().getId());
      final String lowerDoc = doc.toLowerCase();
      final int headIdx = lowerDoc.indexOf("<head>");
      if (-1 == headIdx) {
          return "";
      } else {
          final int headEndIdx = lowerDoc.indexOf("</head>");
          return (-1 == headEndIdx) ? doc.substring(headIdx) : doc.substring(headIdx, headEndIdx + "</head>".length());
      }
  }

  static void printWithElapsedTime(final Instant start, final String body) {
      System.out.println("printing thread: " + Thread.currentThread().getId());
      System.out.println("Elapsed: " + start.until(Instant.now(), ChronoUnit.MILLIS));
      System.out.println("Result:\n" + body);
  }
}
