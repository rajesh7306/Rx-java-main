# What is RxJava?
Reactive Extension is a powerful library for asynchronous operations built on Java, that is, observable pattern. You can create asynchronous data stream on any thread, transform the data and consumed it by an Observer on any thread. The library offers wide range of amazing operators like map, combine, merge, filter and lot more that can be applied onto data stream.

## Basic concepts

Observable: The class that will do the spreading action of the data.

Observer: It listens to the data in the spreading state and does the inclusion process.

Subscribe: Establishes the connection between Observable and observer.

Schedulers.io(): disk/file reading, database CPU does the work that won't be too busy.<dt>

AndroidSchedulers.mainThread(): This provides access to android Main Thread / UI Thread. Usually operations like updating UI, user interactions happens on this thread. We shouldn’t perform any intensive operations on this thread as it makes the app glitchy or ANR dialog can be thrown.<dt>

## Output of my project<dt>


What is RxJava:
RxJava is a library for composing asynchronous streams of real-time data and event-based programs by using observable sequences in a Reactive Programming style
In Reactive Programming the consumer reacts to the data as it comes in. So, This is the reason why asynchronous programming is also called reactive programming. Basically, Reactive Programming allows to propagates changing in evens to their observers. For instance, in the following equation: X = Y +Z, when we want to change the value of Y or Z, the value of X automatically changes. This change can be accomplished by observing the values of Y and Z at the same time.
 RxJava is the Java implementation of the concept of Reactive Programming in RxJava and Android to react to changes in applications.
How does RxJava work?
As a matter of fact, RxJava extends the Observer software design pattern, which is based on the concept of Observers and Observables. If you want to work with RxJava library, you will see some concepts that play essential roles in implementation. Thus, understanding these concepts are necessary. They are mentioned briefly as follows:
RxJava Basics: Observable, Observer
RxJava is all about two key components: Observable and Observer. In addition to these, there are other things like Schedulers, Operators and Subscription.

Observable: Observable is a data stream that do some work and emits data.

Observer: Observer is the counter part of Observable. It receives the data emitted by Observable.

Subscription: The bonding between Observable and Observer is called as Subscription. There can be multiple Observers subscribed to a single Observable.

Operator / Transformation: Operators modifies the data emitted by Observable before an observer receives them.

Schedulers: Schedulers decides the thread on which Observable should emit the data and on which Observer should receives the data i.e background thread, main thread etc.

The Basic Steps:

1.	Create an Observable that emits data. Below we have created an Observable that emits list of animal names. Here just() operator is used to emit few animal names.

Observable<String> animalsObservable = Observable.just("Ant", "Bee", "Cat", "Dog", "Fox");

2. Create an Observer that listen to Observable. Observer provides the              below interface methods to know the the state of Observable.
•	onSubscribe(): Method will be called when an Observer subscribes to Observable.
•	onNext(): This method will be called when Observable starts emitting the data.
•	onError(): In case of any error, onError() method will be called.
•	onComplete(): When an Observable completes the emission of all the items, onComplete() will be called.
Observer<String> animalsObserver = getAnimalsObserver();

private Observer<String> getAnimalsObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "Name: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "All items are emitted!");
            }
        };
    }
3. Make Observer subscribe to Observable so that it can start receiving the data. Here, you can notice two more methods, observeOn() and subscribeOn().
•	subscribeOn(Schedulers.io()): This tell the Observable to run the task on a background thread.
•	observeOn(AndroidSchedulers.mainThread()): This tells the Observer to receive the data on android UI thread so that you can take any UI related actions.

animalsObservable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(animalsObserver);
Out Put

onSubscribe
Name: Ant
Name: Bee
Name: Cat
Name: Dog
Name: Fox
All items are emitted!


When we use Rx, it helps us by:
	handling the cache without creating caching classes
	combining the reception of requests and results processing and getting rid of standard AsyncTask
	decreasing memory leak by 90%
	optimizing the code to increase an application response
	making methods easier to combine





