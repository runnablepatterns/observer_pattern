package com.runnablepatterns.observerpattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Interface to wrap Subjects that can notify observers
 *
 */
public interface ISubject {

	/**
	 * This is the subscribe method used by observers to be added to notification list
	 * @param _observer The observer to add
	 */
	public void addObserver(IObservable _observer);
	
	/**
	 * This is the unsubscribe method used by observers to be removed from the list
	 * @param _observer The observer to remove
	 */
	public void removeObserver(IObservable _observer);
	
	/**
	 * This method is used to notify all observers once the subject changed
	 */
	public void notifyObservers();
}
