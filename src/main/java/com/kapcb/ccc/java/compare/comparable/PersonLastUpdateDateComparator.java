package com.kapcb.ccc.java.compare.comparable;

import java.util.Comparator;

/**
 * <a>Title: PersonLastUpdateDateComparator </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/20 - 10:44
 */
public class PersonLastUpdateDateComparator implements Comparator<Person> {

    @Override
    public int compare(Person personOne, Person personTwo) {
        int i = personOne.getLastUpdateDate().compareTo(personTwo.getLastUpdateDate());
        if (i == 0) {
            i = personOne.getTotalPoints().compareTo(personTwo.getTotalPoints());
        }
        return i;
    }
}
