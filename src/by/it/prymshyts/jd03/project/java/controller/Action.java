package by.it.prymshyts.jd03.project.java.controller;


public enum Action {
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.inPage  = "/signup.jsp";
            this.okPage  = "/login.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.inPage  = "/login.jsp";
            this.okPage  = "/main.jsp";
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.inPage  = "/logout.jsp";
            this.okPage  = "/login.jsp";
        }
    },
    ERROR {
        {
            this.command = new CommandLogout();
        }
    },
    SHOWUSERS {
        {
            this.command = new CommandShowUsers();
            this.inPage  = "/showusers.jsp";
        }
    },
    SHOWARTICLES {
        {
            this.command = new CommandShowArticles();
            this.inPage  = "/showarticles.jsp";
        }
    },
    CREATEARTICLE {
        {
            this.command = new CommandCreateArticle();
            this.inPage  = "/createarticle.jsp";
        }
    },
    PROFILE {
        {
            this.command = new CommandProfile();
            this.inPage  = "/profile.jsp";
        }
    };

    public String inPage = "/error.jsp";
    public String okPage = "/error.jsp";
    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

    public static final String msgError   = "msg_error";
    public static final String msgMessage = "message";

}