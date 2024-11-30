import models.School;
import models.Controller;

public class App {
    public static void main(String[] args) throws Exception {

        School school = new School("ITIS Molinari");
        Controller controller = new Controller();

        controller.manage_school(school);
    }
}
