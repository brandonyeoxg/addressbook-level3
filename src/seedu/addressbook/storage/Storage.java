package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile.StorageOperationException;

public interface Storage {

    /** Default file path used if the user doesn't provide the file name. */
    public static final String DEFAULT_STORAGE_FILEPATH = "addressbook.txt";    
    
    /**
     * Loads the addressbook from storage.
     * @return Loaded addressbook.
     * @throws StorageOperationException If there is read/write errors.
     */
    public  AddressBook load() throws StorageOperationException;

    /**
     * Gets the path of the saved contact list.
     * @return Loaded addressbook.
     * @throws StorageOperationException If there is read/write errors.
     */    
    public String getPath();
    
    /**
     * Loads the addressbook from storage.
     * @return Loaded addressbook.
     * @throws StorageOperationException If there is read/write errors.
     */    
    public abstract void save(AddressBook addressBook) throws StorageOperationException;

}
