/*
 * Project: 
 * 	Cockpit Valuation Server
 *
 * Author:  
 *	Christian Zirpins
 *
 * Last Change: 
 *	by:   $$Author: $$
 *	date: $$Date:   $$
 *
 * Copyright (c):
 * 	2011 Karlsruhe Institute of Technology (KIT)
 * 
 * License:
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you
 * 	may not use this file except in compliance with the License. You may
 * 	obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * 	Unless required by applicable law or agreed to in writing, software
 * 	distributed under the License is distributed on an "AS IS" BASIS,
 * 	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * 	implied. See the License for the specific language governing
 * 	permissions and limitations under the License.
 */

package edu.kit.cockpit.valuationserver.helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtil {

	/**
	 * @param cal_1
	 * @param cal_2
	 * @return
	 */
	public static long simpleDifferenceInDays(Calendar cal_1, Calendar cal_2) {
		// difference in ms
		long time = cal_2.getTime().getTime() - cal_1.getTime().getTime();
		// difference in days
		return Math.round((double) time / (24. * 60. * 60. * 1000.));
	}

	/**
	 * @param dt
	 * @return
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar getXmlGregCal(Date dt)
			throws DatatypeConfigurationException {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dt);
		XMLGregorianCalendar xgc = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gc);
		return xgc;
	}

	/**
	 * @param pollDeadline
	 * @return
	 */
	public static Date getDate(XMLGregorianCalendar xcal) {
		Date dt = xcal.toGregorianCalendar().getTime();
		return dt;
	}

	/**
	 * @param date
	 * @return
	 */
	public static boolean pastDate(Date date) {
		if (date == null)
			return false;
		return (new Date()).after(date);
	}

	/**
	 * @param date
	 * @return
	 */
	public static boolean futureDate(Date date) {
		if (date == null)
			return false;
		return date.after(new Date());
	}

}
