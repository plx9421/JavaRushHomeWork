package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 17.02.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    //    private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";
    private static final String USER_AGENT = "Mozilla/5.0 (jsoup)";
    private static final String REFER = "http://javarush.ru";
    private static final int TIMEOUT = 5 * 1000;

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        Elements elements = null;
        List<Vacancy> list = new ArrayList<>();
        int page = 0;
        while (true)
        {
            try
            {
                elements = getDocument(searchString, page).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            if (elements != null && elements.size() > 0)
            {
                for (Element element : elements)
                {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(
                            element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setSiteName("hh.ua");
                    vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                    list.add(vacancy);
                }
                page++;
            } else break;
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {

//        String param = URLEncoder.encode(searchString, "UTF-8");
        String url = String.format(URL_FORMAT, searchString, page);

        Document doc = null;
        doc = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFER).timeout(TIMEOUT).get();

        return doc;
    }
}

