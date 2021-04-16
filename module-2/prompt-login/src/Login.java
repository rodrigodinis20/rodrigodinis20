import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;


public class Login {

    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.in, System.out);
        StringInputScanner login = new StringInputScanner();
        PasswordInputScanner password = new PasswordInputScanner();


        login.setMessage("Please insert username: ");
        password.setMessage("Please insert password: ");
        String li = prompt.getUserInput(login);
        String pw = prompt.getUserInput(password);

        while (!pw.equals("test")) {
            if (!pw.equals("test")) {
                System.out.println("User: " + li + "\n" + "Password: " + pw + " \nPassword is incorrect...");

            } else {
                System.out.println("User: " + li + "\n" + "Password: " + pw + "\nLogin successful");
                break;
            }
        }
    }
}
