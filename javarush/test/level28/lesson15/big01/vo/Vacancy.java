package com.javarush.test.level28.lesson15.big01.vo;

/**
 * Created by Alexey on 17.02.2016.
 */
public class Vacancy
{
    private String title;
    private String salary;
    private String city;
    private String companyName;
    private String siteName;
    private String url;

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getTitle()
    {
        return title;
    }

    public String getSalary()
    {
        return salary;
    }

    public String getCity()
    {
        return city;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public String getSiteName()
    {
        return siteName;
    }

    public String getUrl()
    {
        return url;
    }

    @Override
    public int hashCode()
    {
        return salary.hashCode() + title.hashCode() + city.hashCode() + companyName.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;

        Vacancy v = (Vacancy) obj;

        if (!this.title.equals(v.getTitle())) return false;
        if (!this.salary.equals(v.getSalary())) return false;
        if (!this.companyName.equals(v.getCompanyName())) return false;
        if (!this.city.equals(v.getCity())) return false;

        return true;
    }

    @Override
    public String toString()
    {
        return "Vacancy{" +
                "title='" + title + '\'' +
                ", salary='" + salary + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", siteName='" + siteName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
