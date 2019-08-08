package com.runnablepatterns.observerpattern;

import java.time.LocalDateTime;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to display Executive Dahsboard details
 * This class is one of the observers of Survey Data
 *
 */
public class ExecutiveDashboard implements IObservable {

	/**
	 * Reference to Subject to be able to register or unsubscribe from the list
	 */
	private ISubject subject;
	
	/**
	 * Overloaded constructor to define which subject will be use
	 * @param _subject The subject to use for notifications
	 */
	public ExecutiveDashboard(ISubject _subject) {
		this.subject = _subject;
		// add this class as one observer
		this.subject.addObserver(this);
	}
	
	@Override
	public void update(ISubject _subject) {
		// set the subject
		this.subject = _subject;
		
		// display updated details
		displayDetails();
	}
	
	/**
	 * This method just displays the information using a format
	 */
	public void displayDetails() {
		// check if is the required instance
		if(this.subject instanceof SurveyData) {
			// convert it to required subject
			SurveyData survey = (SurveyData)this.subject;
			
			// display the information
			System.out.println("Displaying details for Executive Dashboard");
			System.out.println(String.format("Survey: %s | Score: %s", survey.getSurveyName(),
					survey.getCurrentScore()));
			System.out.println(String.format("Last update: %s", LocalDateTime.now()));
			System.out.println();
		}
	}

}
