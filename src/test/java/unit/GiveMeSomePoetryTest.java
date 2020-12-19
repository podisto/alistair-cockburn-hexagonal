package unit;

import com.simba.adapters.infrastructure.InMemoryPoetryAdapter;
import com.simba.domain.IObtainPoems;
import com.simba.domain.IRequestVerses;
import com.simba.domain.PoetryReader;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class GiveMeSomePoetryTest {

    private final IObtainPoems poetryRepository = new InMemoryPoetryAdapter();
    IRequestVerses poetryRequester = new PoetryReader(poetryRepository);

    @Test
    public void shouldWritePoetry() {
        poetryRequester.write("Swat the files");
        assertEquals("Swat the files", poetryRepository.all().iterator().next());
    }

    @Test
    public void shouldGiveMeSomePoetry() {
        poetryRepository.add("I want to sleep");
        Set<String> poetries = poetryRequester.giveMeSomePoetry();
        assertFalse(poetries.isEmpty());
        assertTrue(poetries.contains("I want to sleep"));
    }
}
