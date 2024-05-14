class FooBar {
    private int n;
    // https://algo.monster/liteproblems/1115
    private final int loopCount; // The number of times "foo" and "bar" should be printed.
    private final Semaphore fooSemaphore = new Semaphore(1); // A semaphore for "foo", allowing "foo" to print first.
    private final Semaphore barSemaphore = new Semaphore(0); // A semaphore for "bar", initially locked until "foo" is
                                                             // printed.

    public FooBar(int n) {
        this.loopCount = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < loopCount; i++) {

            fooSemaphore.acquire(); // Acquire a permit before printing "foo", ensuring "foo" has the turn to print
            printFoo.run(); // Output "foo"
            barSemaphore.release(); // Release a permit for "bar" after "foo" is printed, allowing "bar" to print
                                    // next
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < loopCount; i++) {
             barSemaphore.acquire(); // Acquire a permit before printing "bar", ensuring "bar" has the turn to print
            printBar.run();         // Output "bar"
            fooSemaphore.release();
        }
    }
}