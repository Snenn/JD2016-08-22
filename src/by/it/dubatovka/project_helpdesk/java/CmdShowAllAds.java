package by.it.dubatovka.project_helpdesk.java;

import by.it.dubatovka.project_helpdesk.java.beans.Ad;
import by.it.dubatovka.project_helpdesk.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class CmdShowAllAds extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        List<Ad> adsList=dao.ad.getAll("");
        req.setAttribute("adsList",adsList);

        return Actions.SHOWALLADS.action;
    }
}
