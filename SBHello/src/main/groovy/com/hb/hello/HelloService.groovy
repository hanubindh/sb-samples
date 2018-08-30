@RestController
class HelloService {

    @RequestMapping("/")
    String home() {
        return "Hello World!"
    }

}