package seedu.addressbook.storage.exception;

/**
 * Signals that some error has occured while trying to convert and read/write data between the application
 * and the storage file.
 */
public class StorageOperationException extends InvalidStorageFilePathException {
 
    public StorageOperationException(String message) {
        super(message);
    }
}
