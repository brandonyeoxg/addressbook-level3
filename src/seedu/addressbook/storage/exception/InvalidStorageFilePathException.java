package seedu.addressbook.storage.exception;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Signals that the given file path does not fulfill the storage filepath constraints.
 */
public class InvalidStorageFilePathException extends IllegalValueException {

    public InvalidStorageFilePathException(String message) {
        super(message);
    }
    
}
