package com.runnablepatterns.observerpattern;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Interface to wrap all Observers of a specific Subject
 *
 */
public interface IObservable {
	/**
	 * Method to handle the update process once a change is trigger in the subject
	 * @param _subject The subject that changed
	 */
	public void update(ISubject _subject);
}
