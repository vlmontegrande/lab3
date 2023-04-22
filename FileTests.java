import static org.junit.Assert.*;
import org.junit.*;
import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;


public class FileTests {
	@Test 
	public void testGetFiles() {
        File file1 = new File("some-files/");
        File file2 = new File("some-files/more-files");
        File file3 = new File("some-files/a.txt");
        try {
            List<File> list1 = FileExample.getFiles(file1);
            List<File> list2 = FileExample.getFiles(file2);
            List<File> list3 = FileExample.getFiles(file3);
            assertArrayEquals(new File[]{new File("some-files/a.txt"),
                new File("some-files/more-files/b.txt"), new File("some-files/more-files/c.java"),
                new File("some-files/even-more-files/d.java"), new File("some-files/even-more-files/a.txt")}, (File[])list1.toArray(new File[0]));
            assertArrayEquals(new File[]{new File("some-files/more-files/b.txt"), new File("some-files/more-files/c.java")}, (File[])list2.toArray(new File[0]));
            assertArrayEquals(new File[]{new File("some-files/a.txt")}, (File[])list3.toArray(new File[0]));
        } catch (Exception e) {

        }

	}
}
