package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

/**
 * Finds Persons by tags that they are linked to.
 * This command is case sensitive
 */
public class FindByTagCommand extends Command{
    public static final String COMMAND_WORD = "find -t";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Finds all persons whose tag(s) contain any of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n\t"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n\t"
            + "Example: " + COMMAND_WORD + " alice bob charlie";
    
    private final Set<String> keywords;
   
    public FindByTagCommand(Set<String> keywords) {
        this.keywords = keywords;
    }
    
    /**
     * Returns copy of keywords in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }    
    
    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithTagsContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }
    
    /**
     * Retrieve all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithTagsContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> tagsInName = new HashSet<>();
            getTagsInPerson(person, tagsInName);
            if (!Collections.disjoint(tagsInName, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    /**
     * Finds and collates all the tags that belongs to a person.
     * 
     * @param person Person from whom we find the tags from.
     * @param tagsInName Stores the tags that the person has.
     */
    private void getTagsInPerson(ReadOnlyPerson person, final Set<String> tagsInName) {
        for(Tag tag : person.getTags()) {
            tagsInName.add(tag.tagName);
        }
    }    

}
