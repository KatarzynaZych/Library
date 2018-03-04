package com.kodilla.library;
import com.kodilla.library.domain.Copy;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.CopyRepository;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.TitleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllRepositoryTestSuite {

    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private CopyRepository copyRepository;

    @Test
    public void testGetReader() {
        //given
        Reader reader = new Reader("Jennifer", "Taylor", LocalDate.of(2017, 2, 6));
        //when
        readerRepository.save(reader);
        //then
        int readerId = reader.getId();
        Reader readerInBase = readerRepository.findById(readerId);
        Assert.assertEquals(readerId, readerInBase.getId());
        //clean up
        readerRepository.delete(readerInBase);
    }

    @Test
    public void testAddReader() {
        //given
        Reader reader1 = new Reader(1,"Nora", "Jones", LocalDate.of(2017, 2, 6));
        Reader reader2 = new Reader(2,"John", "Taylor", LocalDate.of(2017, 2, 6));
        //when
        readerRepository.save(reader1);
        readerRepository.save(reader2);
        //then
        Assert.assertEquals(2, readerRepository.count());
        //clean up
        readerRepository.deleteAll();
    }

    @Test
    public void testAddTitle() {
        //given
        Title title1 = new Title("Beginning Java Programming For Dummies", "John Smith", LocalDate.of(2001, 02, 01));
        Title title2 = new Title("Thinking in Java", "Josh Jazz", LocalDate.of(2005, 02, 01));
        Title title3 = new Title("Oracle Certified Associate Java SE 8 Programmer", "Max Thomson", LocalDate.of(2017, 05, 3));
        //when
        titleRepository.save(title1);
        titleRepository.save(title2);
        titleRepository.save(title3);
        //then
        Assert.assertEquals(3, titleRepository.count());
        //clean up
        titleRepository.deleteAll();
    }

    @Test
    public void testGetTitles() {
        //given
        Title title1 = new Title("Beginning Java Programming For Dummies", "John Smith", LocalDate.of(2001, 02, 01));
        Title title2 = new Title("Thinking in Java", "Josh Jazz", LocalDate.of(2005, 02, 01));
        Title title3 = new Title("Oracle Certified Associate Java SE 8 Programmer", "Max Thomson", LocalDate.of(2017, 05, 3));
        //when
        titleRepository.save(title1);
        titleRepository.save(title2);
        titleRepository.save(title3);
        //then
        int bookNumber = titleRepository.findAll().size();
        Assert.assertEquals(3, bookNumber);
        //clean up
        titleRepository.deleteAll();
    }

    @Test
    public void testAddCopy() {
        //given
        Title title1 = new Title("Beginning Java Programming For Dummies", "John Smith", LocalDate.of(2001, 02, 01));
        Title title2 = new Title("Thinking in Java", "Josh Jazz", LocalDate.of(2005, 02, 01));
        Title title3 = new Title("Oracle Certified Associate Java SE 8 Programmer", "Max Thomson", LocalDate.of(2017, 05, 3));

        Copy copy1 = new Copy(1,1,"broken");
        Copy copy2 = new Copy(2,1,"in");
        Copy copy3 = new Copy(3,1,"out");
        Copy copy4 = new Copy(4,2,"lost");
        Copy copy5 = new Copy(5,2,"in");
        Copy copy6 = new Copy(6,3,"out");

        List<Copy> copyListA = new ArrayList<>();
        List<Copy> copyListB = new ArrayList<>();
        List<Copy> copyListC = new ArrayList<>();

        copyListA.add(copy1);
        copyListA.add(copy2);
        copyListA.add(copy3);
        copyListB.add(copy4);
        copyListB.add(copy5);
        copyListC.add(copy6);

        title1.setCopyList(copyListA);
        title2.setCopyList(copyListB);
        title3.setCopyList(copyListC);
        copy1.setTitle(title1);
        copy2.setTitle(title1);
        copy3.setTitle(title1);
        copy4.setTitle(title2);
        copy5.setTitle(title2);
        copy6.setTitle(title3);
        //when
        titleRepository.save(title1);
        titleRepository.save(title2);
        titleRepository.save(title3);
        copyRepository.save(copy1);
        copyRepository.save(copy2);
        copyRepository.save(copy3);
        copyRepository.save(copy4);
        copyRepository.save(copy5);
        copyRepository.save(copy6);

        //then
        Assert.assertEquals(6, copyRepository.count());
        //clean up
        copyRepository.deleteAll();
    }
}
