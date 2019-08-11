package com.runnablepatterns.observerpattern;

import java.util.ArrayList;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to store survey information.
 * This class is the subject that will notify all observers once data is updated
 *
 */
public class SurveyData implements ISubject {

	/**
	 * The name of the survey
	 */
	private String surveyName;
	
	/**
	 * Total answers provided to this survey
	 */
	private int totalAnswers;
	
	/**
	 * Current score after computing the answers
	 */
	private double currentScore;
	
	/**
	 * The list of observers to notify when data change
	 */
	private ArrayList<IObservable> observers;
	
	/**
	 * Variable used to keep track of current state
	 */
	private boolean changed;
	
	/**
	 * Overloaded constructor.
	 * @param _surveyName The survey name to use
	 */
	public SurveyData(String _surveyName) {
		// initialize observer list
		this.observers = new ArrayList();
		this.surveyName = _surveyName;
	}
	
	@Override
	public void addObserver(IObservable _observer) {
		// add observer
		this.observers.add(_observer);
	}

	@Override
	public void removeObserver(IObservable _observer) {
		// remove observer
		int observerIndex = this.observers.indexOf(_observer);
		if(observerIndex >= 0) {
			this.observers.remove(observerIndex);
		}
	}

	@Override
	public void notifyObservers() {
		// check if the state changed
		if(this.getState() == false) {
			return;
		}
		
		// notify all observers
		for(int index = 0; index < this.observers.size(); index++) {
			this.observers.get(index).update(this);
		}
	}
	
	/**
	 * This method just receives the calculated values for this survey.
	 * @param _totalAnswers Number of total answers to set
	 * @param _score Current survey score to set
	 */
	public void surveyUpdate(int _totalAnswers, double _score) {
		// check if the values changed
		if(this.totalAnswers != _totalAnswers || this.currentScore != _score) {
			// set the state to true
			this.setState(true);
		}
		this.totalAnswers = _totalAnswers;
		this.currentScore = _score;
		
		// only notify if state has changed
		if(this.getState()) {
			// notify all observers
			this.notifyObservers();
			this.setState(false);
		}
	}
	
	/**
	 * Get current survey name
	 * @return The survey name
	 */
	public String getSurveyName() {
		return surveyName;
	}

	/**
	 * Get the total survey answers
	 * @return The survey answers count
	 */
	public int getTotalAnswers() {
		return totalAnswers;
	}

	/**
	 * Get the current survey score
	 * @return The survey score
	 */
	public double getCurrentScore() {
		return currentScore;
	}

	/**
	 * Get the current state
	 * @return True if changed
	 */
	public boolean getState() {
		return changed;
	}

	/**
	 * Set the current state
	 * @param changed The state to set
	 */
	public void setState(boolean changed) {
		this.changed = changed;
	}

}
