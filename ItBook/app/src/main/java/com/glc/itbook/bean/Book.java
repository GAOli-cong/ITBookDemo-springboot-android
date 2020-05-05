package com.glc.itbook.bean;

import java.util.List;

public class Book {

    /**
     * currentPage : 1
     * pageSize : 10
     * totalNum : 8516
     * isMore : 1
     * totalPage : 852
     * items : [{"id":1,"book_name":"PowerPoint 2019 For Dummies","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/PowerPoint-2019-For-Dummies.jpg","book_author":"Doug Lowe","book_info":"Get up and running fast with the PowerPoint 2019 PowerPoint continues to be the go-to tool for business presentations. The software helps anyone who needs to communicate clearly by creating powerful and effective slideshow presentations featuring data in the form of charts, clip art, sound, and video. You\u2026","book_download":"http://file.allitebooks.com/20200323/PowerPoint 2019 For Dummies.pdf","book_FileSize":" 30.9 MB"},{"id":2,"book_name":"Practical Highcharts with Angular","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/Practical-Highcharts-with-Angular.jpg","book_author":"Sourabh Mishra","book_info":"Learn to create stunning animated and interactive charts using Highcharts and Angular. Use and build on your existing knowledge of HTML, CSS, and JavaScript to develop impressive dashboards that will work in all modern browsers. You will learn how to use Highcharts, call backend services for data, and\u2026","book_download":"http://file.allitebooks.com/20200321/Practical Highcharts with Angular.pdf","book_FileSize":" 5.9 MB"},{"id":3,"book_name":"iPad For Seniors For Dummies, 12th Edition","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/iPad-For-Seniors-For-Dummies-12th-Edition.jpg","book_author":"Dwight Spivey","book_info":"Get to know the exciting features of your new iPad! The iPad can do almost anything: entertain you, help you stay in touch with the world, boost your productivity, and more. If you have lots of life experience but are a little less tech savvy, iPad For Seniors For\u2026","book_download":"http://file.allitebooks.com/20200320/iPad For Seniors For Dummies, 12th Edition.epub","book_FileSize":" 35.7 MB"},{"id":4,"book_name":"Impractical Python Projects","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/Impractical-Python-Projects.jpg","book_author":"Lee Vaughan","book_info":"Impractical Python Projects is a collection of fun and educational projects designed to entertain programmers while enhancing their Python skills. It picks up where the complete beginner books leave off, expanding on existing concepts and introducing new tools that you\u2019ll use every day. And to keep things interesting, each\u2026","book_download":"http://file.allitebooks.com/20200319/Impractical Python Projects.pdf","book_FileSize":" 10.2 MB"},{"id":5,"book_name":"Cognitive Virtual Assistants Using Google Dialogflow","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/Cognitive-Virtual-Assistants-Using-Google-Dialogflow.jpg","book_author":"Amit Agrawal","book_info":"Follow a step-by-step, hands-on approach to building production-ready enterprise cognitive virtual assistants using Google Dialogflow. This book provides an overview of the various cognitive technology choices available and takes a deep dive into cognitive virtual agents for handling complex real-life use cases in various industries such as travel\u2026","book_download":"http://file.allitebooks.com/20200318/Cognitive Virtual Assistants Using Google Dialogflow.pdf","book_FileSize":" 6.4 MB"},{"id":6,"book_name":"MySQL 8 Query Performance Tuning","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/MySQL-8-Query-Performance-Tuning.jpg","book_author":"Jesper Wisborg Krogh","book_info":"Identify, analyze, and improve poorly performing queries that damage user experience and lead to lost revenue for your business. This book will help you make query tuning an integral part of your daily routine through a multi-step process that includes monitoring of execution times, identifying candidate queries for\u2026","book_download":"http://file.allitebooks.com/20200318/MySQL 8 Query Performance Tuning.pdf","book_FileSize":" 17.7 MB"},{"id":7,"book_name":"PostgreSQL Configuration","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/PostgreSQL-Configuration.jpg","book_author":"Baji Shaik","book_info":"Obtain all the skills you need to configure and manage a PostgreSQL database. In this book you will begin by installing and configuring PostgreSQL on a server by focusing on system-level parameter settings before installation. You will also look at key post-installation steps to avoid issues in the\u2026","book_download":"http://file.allitebooks.com/20200317/PostgreSQL Configuration.pdf","book_FileSize":" 2.3 MB"},{"id":8,"book_name":"Teach Yourself VISUALLY iPhone 11, 11Pro, and 11 Pro Max, 5th Edition","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/Teach-Yourself-VISUALLY-iPhone-11-11Pro-and-11-Pro-Max-5th-Edition.jpg","book_author":"Guy Hart-Davis","book_info":"Know your new iPhone 11, 11 Pro, and 11 Pro Max from the inside-out with 900 color screen shots! Teach Yourself VISUALLY iPhone is your ultimate guide to getting the most out of your iPhone! Apple\u2019s graphics-driven iOS is perfect for visual learners, so this book uses a visual\u2026","book_download":"http://file.allitebooks.com/20200316/Teach Yourself VISUALLY iPhone 11, 11Pro, and 11 Pro Max, 5th Edition.epub","book_FileSize":" 148 MB"},{"id":9,"book_name":"Head First Go","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/Head-First-Go1-400x461.png","book_author":"Jay McGavren","book_info":"What will you learn from this book? Go makes it easy to build software that\u2019s simple, reliable, and efficient. Andthis book makes it easy for programmers like you to get started. Googledesigned Go for high-performance networking and multiprocessing, but\u2014like Python and JavaScript\u2014the language is easy to read and\u2026","book_download":"http://file.allitebooks.com/20200315/Head First Go.pdf","book_FileSize":" 97.5 MB"},{"id":10,"book_name":"Essential ASP.NET Web Forms Development","book_img":"http://www.allitebooks.org/wp-content/uploads/2020/03/Essential-ASP.NET-Web-Forms-Development.jpg","book_author":"Robert E. Beasley","book_info":"Go from beginner to pro using one of the most effective and widely used technology stacks, Microsoft ASP.NET. Beginning with the basics, you will learn how to create interactive, professional-grade, database-driven web applications in no time, using ASP.NET, C#, SQL, Ajax, and JavaScript. Essential ASP.NET Web Forms Development is\u2026","book_download":"http://file.allitebooks.com/20200314/Essential ASP.NET Web Forms Development.pdf","book_FileSize":" 18.9 MB"}]
     */

    private int currentPage;
    private int pageSize;
    private int totalNum;
    private int isMore;
    private int totalPage;
    private List<ItemsBean> items;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getIsMore() {
        return isMore;
    }

    public void setIsMore(int isMore) {
        this.isMore = isMore;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * id : 1
         * book_name : PowerPoint 2019 For Dummies
         * book_img : http://www.allitebooks.org/wp-content/uploads/2020/03/PowerPoint-2019-For-Dummies.jpg
         * book_author : Doug Lowe
         * book_info : Get up and running fast with the PowerPoint 2019 PowerPoint continues to be the go-to tool for business presentations. The software helps anyone who needs to communicate clearly by creating powerful and effective slideshow presentations featuring data in the form of charts, clip art, sound, and video. You…
         * book_download : http://file.allitebooks.com/20200323/PowerPoint 2019 For Dummies.pdf
         * book_FileSize :  30.9 MB
         */

        private int id;
        private String book_name;
        private String book_img;
        private String book_author;
        private String book_info;
        private String book_download;
        private String book_FileSize;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBook_name() {
            return book_name;
        }

        public void setBook_name(String book_name) {
            this.book_name = book_name;
        }

        public String getBook_img() {
            return book_img;
        }

        public void setBook_img(String book_img) {
            this.book_img = book_img;
        }

        public String getBook_author() {
            return book_author;
        }

        public void setBook_author(String book_author) {
            this.book_author = book_author;
        }

        public String getBook_info() {
            return book_info;
        }

        public void setBook_info(String book_info) {
            this.book_info = book_info;
        }

        public String getBook_download() {
            return book_download;
        }

        public void setBook_download(String book_download) {
            this.book_download = book_download;
        }

        public String getBook_FileSize() {
            return book_FileSize;
        }

        public void setBook_FileSize(String book_FileSize) {
            this.book_FileSize = book_FileSize;
        }
    }
}
