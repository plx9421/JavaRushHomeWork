package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 26.02.2016.
 */
public class HtmlViewTest
{

    @Test
    public void testUpdate() throws Exception
    {

        List<Vacancy> v = new ArrayList<Vacancy>();
//("Senior Java Developer", "", "Одесса", "Luxoft","hh.ua","http://hh.ua/vacancy/16005582?query=java%20Odessa");
//Vacancy{title='Java Developer', salary='', city='Одесса', companyName='Luxoft', siteName='hh.ua', url='http://hh.ua/vacancy/15873078?query=java%20Odessa'}
//Vacancy{title='Web developer', salary='', city='Одесса', companyName='Key people recruiting', siteName='hh.ua', url='http://hh.ua/vacancy/15900912?query=java%20Odessa'}
//Vacancy{title='Technical Implementation Consultant', salary='', city='Одесса', companyName='Alpha Technologies Inc', siteName='hh.ua', url='http://hh.ua/vacancy/15584052?query=java%20Odessa'}
//Vacancy{title='Администратор систем дистанционного обслуживания клиентов', salary='', city='Одесса', companyName='Пивденный, Акционерный Банк', siteName='hh.ua', url='http://hh.ua/vacancy/16050406?query=java%20Odessa'}
//Vacancy{title='Senior Automation Tests Engineer', salary='', city='Одесса', companyName='Alpha Technologies Inc', siteName='hh.ua', url='http://hh.ua/vacancy/15362094?query=java%20Odessa'}
//Vacancy{title='Application Architect (Montenegro)', salary='', city='Одесса', companyName='Группа компаний FOREX CLUB', siteName='hh.ua', url='http://hh.ua/vacancy/15946417?query=java%20Odessa'}
//Vacancy{title='Android developer (Montenegro)', salary='', city='Одесса', companyName='Группа компаний FOREX CLUB', siteName='hh.ua', url='http://hh.ua/vacancy/15854339?query=java%20Odessa'}
//Vacancy{title='Automation QA Engineer', salary='', city='Одесса', companyName='Luxoft', siteName='hh.ua', url='http://hh.ua/vacancy/15873323?query=java%20Odessa'}
//Vacancy{title='Java Developer', salary='', city='Одесса', companyName='PLS Logistics Services', siteName='hh.ua', url='http://hh.ua/vacancy/15910662?query=java%20Odessa'}
        new HtmlView().update(v);


    }

    @Test
    public void testGetDocument() throws Exception
    {

    }
}