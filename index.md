# Lab Report 2: Electric Boogaloo (Servers and Bugs)

Taking CSE 12 and CSE 15L? Experiencing bugs in your code and feeling hopeless? lmao that sucks

anyways look at my cool web server

```
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String out = "";

    public String handleRequest(URI url) {
        if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                out += parameters[1] + "\n";
                return String.format(out);
            }
        } 
        return "404 Not Found!";
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```

![Image](https://github.com/vlmontegrande/lab3/blob/c25d05a2fbf3e92f07c6db7466e4dc70b38f2bf7/Screenshot%20(2).png)
![Image](https://github.com/vlmontegrande/lab3/blob/fdf90934e342f37fbbcccc22864b2379fa2c4b2b/Screenshot%20(3).png)
