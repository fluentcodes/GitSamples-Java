## [GitSamples](/../../tree/master) - [Structural](/../../tree/java-design-pattern/test/samples/structural): Proxy Pattern
<cite>In short, a proxy is a wrapper or agent object that is being called by the client to access the real serving object behind the scenes. </cite>

### Problems
* The access to an object should be controlled.
* Additional functionality should be provided when accessing an object.

When accessing sensitive objects, for example, it should be possible to check that clients have the needed access rights.
What solution does the Proxy design pattern describe?

### Solution
* can be used as substitute for another object (Subject) and
* implements additional functionality to control the access to this subject.

### Examples
We have an interface [ProxyInterface](ProxyInterface.java) with the method **process**.

The class which should be proxied is [ProxySubject](ProxySubject.java), which is 
supposed to have a costly initialization. 

The [Proxy](Proxy.java) class has [ProxySubject](ProxySubject.java) as instance var which would be initialized only one time in lifetime to avoid cost of initialization.

    public void process() {
        if (proxySubject == null) {
            proxySubject = new ProxySubject();
        }
        proxySubject.process();
    }

Simple test are in [ProxyTest](ProxyTest.java).

### Links
* https://en.wikipedia.org/wiki/Proxy_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://en.wikipedia.org/wiki/Structural_pattern
* https://de.wikipedia.org/wiki/Stellvertreter_(Entwurfsmuster)
* https://www.baeldung.com/java-proxy-pattern
