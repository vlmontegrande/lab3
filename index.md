# Lab Report 2: Electric Boogaloo (Servers and Bugs)

## Part 1

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
---
![Image](Screenshot (2).png)

This image shows the initial state of the server. Of course, booting up the server caused the **main** method in the code to be called. Also, the **handleRequest** method was called. 

When the main method was called, the port of 4000 was given through the command line as an argument. This int was parsed and was used as the server port. Also, when handleRequest was called, the URI of "http://localhost:4000/add-message?s=hello%20world" was passed as an argument. After the if statement checks that the path equals "add-message", the String array *parameters* had the two elements of the query: "s", and "hello world". The if statement confirmed that the first element was "s". After this, the String instance variable *out* gained the value "hello world\n" and was returned.

The field of *out* was changed. This is because the "add-message" path indicated that the query needed to be added to. It was changed from "" to "hello world\n".

---
![Image](Screenshot (3).png)

This screenshot shows a very similar process. 

The **main** method and the **handleRequest** method were called.

When handleRequest was called, the URI of "http://localhost:4000/add-message?s=hello%20world" was passed as an argument. After the if statement checks that the path equals "add-message", the String array *parameters* had the two elements of the query: "s", and "supercalfragilisticexpialidocious". The if statement confirmed that the first element was "s". After this, the String instance variable *out* gained the value "supercalifragilisticexpialidocious\n" and was returned.

The field of *out* was changed. This is because the "add-message" path indicated that the query needed to be added to. It was changed from "hello world\n" to "hello world\nsupercalifragilisticexpialidocious\n".

---

## Part 2

This bug is from ListExamples.java. 

Before code: 

```
static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0, s);
      }
    }
    return result;
  }
```

This bug was caused by the line 
`result.add(0, s);`

The symptom was that the Strings that passed the String Checker would be in reverse order in the List that was returned, even though the description said the order would be preserved. The input was any input that had multiple Strings that passed the String Checker. Of course, the bug was caused by the index being 0 in the add arguments.

After code:

```
static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(s);
      }
    }
    return result;
  }
```

This bug was fixed by removing the index argument from result.add. This is because since the add method would add each String to the list's beginning, the order that they were in wouldn't be preserved. However, without this index, the add method just adds the element at the end. This means the order would be preserved.

## Part 3

The lab from week 2 taught me a lot of things. I finally know why URLs look like that. It's kind of crazy that I went 18 years without knowing what a path and a query was in a URL. Also, learning how to set up a web server was really cool.
