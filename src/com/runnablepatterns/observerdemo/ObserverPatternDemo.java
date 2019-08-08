package com.runnablepatterns.observerdemo;

import com.runnablepatterns.observerpattern.ExecutiveDashboard;
import com.runnablepatterns.observerpattern.GeneralDashboard;
import com.runnablepatterns.observerpattern.SurveyData;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to demonstrate Observer pattern
 *
 */
public class ObserverPatternDemo {

	public static void main(String[] args) {
		// create the subject
		SurveyData surveyData = new SurveyData("Q1 Survey");

		// create the general dashboard/observer
		GeneralDashboard generalDashboard = new GeneralDashboard(surveyData);
		
		// create the executive dashboard/observer
		ExecutiveDashboard executiveDashboard = new ExecutiveDashboard(surveyData);
		
		// refresh the survey details and wait 5 seconds between each update
		surveyData.surveyUpdate(10, 75);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		surveyData.surveyUpdate(15, 70);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		surveyData.surveyUpdate(15, 70);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		surveyData.surveyUpdate(25, 80);
	}

}
