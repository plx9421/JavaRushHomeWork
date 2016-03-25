package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Alexey on 20.02.2016.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath = "./src/" +
            this.getClass().getPackage().getName().replace(".", "/") + "/" + "vacancies.html";

    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Odessa");
//        controller.onCitySelect("Dnepropetrovsk");

    }

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    private String getUpdatedFileContent(List<Vacancy> list)
    {
        Document document = null;
        try
        {
            document = getDocument();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Some exception occurred";
        }

        Element e1 = document.getElementsByClass("template").first();
        Element e2 = e1.clone();

        e2.removeAttr("style");
        e2.removeClass("template");

        for (Element e3 : document.getElementsByClass("vacancy")){
            if (e3.getElementsByClass("template").size() == 0) e3.remove();
        }


        for(Vacancy v : list){
            Element e4 = e2.clone();
            e4.getElementsByClass("city").get(0).text(v.getCity());
            e4.getElementsByClass("companyName").get(0).text(v.getCompanyName());
            e4.getElementsByClass("salary").get(0).text(v.getSalary());
            e4.getElementsByTag("a").get(0).text(v.getTitle());
            e4.getElementsByTag("a").get(0).attr("href", v.getUrl());

            e1.before(e4.outerHtml());

        }

        return document.toString();
    }

    private void updateFile(String string) throws IOException
    {
        FileWriter fw = new FileWriter(filePath, false);
        fw.write(string);
        fw.close();
    }

    protected Document getDocument() throws IOException
    {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
