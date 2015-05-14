
package org.oni.webapp.controller;

import org.oni.webapp.controller.abstracts.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is the controller of the portal screen.
 * @author DungTV
 */
@Controller
@RequestMapping(value = "/admin/")
public class BackendHomeController extends AbstractController {

    /** View name */
    private static final String VIEW_NAME = "admin/Home";

    /**
     * display the portal screen.
     * @param modelMap Map is used to store the data to be passed to the view
     * @return View name
     */
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String view(ModelMap modelMap) {

        
        return VIEW_NAME;
    }
    

}
