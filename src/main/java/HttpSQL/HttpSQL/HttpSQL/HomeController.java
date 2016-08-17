package HttpSQL.HttpSQL.HttpSQL;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private SQLDAO dao = SQLDAO.GetMapper();

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/putsql")
	// @ResponseBody
	public String putsql() {

		dao.test();
		dao.insert("title", "author", "price");
		dao.getAll();
		return "redirect:/getall";
	}

	@RequestMapping(value = "/getall")
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getall");
		mv.addObject("list", dao.getAll());
		return mv;
	}

}