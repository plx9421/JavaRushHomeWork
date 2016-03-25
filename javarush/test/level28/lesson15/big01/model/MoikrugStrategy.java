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
 * Created by Alexey on 26.02.2016.
 */
public class MoikrugStrategy implements Strategy
{

            private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
//    private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";
    private static final String USER_AGENT = "Mozilla/5.0 (jsoup)";
    private static final String REFER = "http://javarush.ru";
    private static final int TIMEOUT = 100;

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> list = new ArrayList<>();
        int page = 1;
        while (true)
        {
            try
            {
                Document document = getDocument(searchString, page);
                Elements elements = document.getElementsByClass("job");

                if (elements != null && elements.size() > 0)
                {
                    for (Element element : elements)
                    {
                        Vacancy vacancy = new Vacancy();

                        vacancy.setUrl("https://moikrug.ru" + element.getElementsByTag("a").attr("href"));

                        vacancy.setTitle(element.getElementsByClass("title").text());

                        if (element.getElementsByClass("location").size() > 0)
                            vacancy.setCity(element.getElementsByClass("location").first().getElementsByTag("a").text());
                        else vacancy.setCity("");

                        if (element.getElementsByClass("company_name").size() > 0)
                            vacancy.setCompanyName(
                                    element.getElementsByClass("company_name").first().getElementsByTag("a").text());
                        else vacancy.setCompanyName("");

                        vacancy.setSiteName("moikrug.ru");
                        vacancy.setSalary(element.getElementsByClass("count").text());
                        list.add(vacancy);
                    }
                    page++;
//                    break;
                } else break;
            }
            catch (IOException e)
            {
//                e.printStackTrace();
            }

        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {

        String url = String.format(URL_FORMAT, page, searchString);

        return Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFER).get();
    }
}
