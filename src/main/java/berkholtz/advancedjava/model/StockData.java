
package berkholtz.advancedjava.model;

import java.text.SimpleDateFormat;

/**
 * Abstract Base class for classes that hold Stock data.
 * Provides common code for such classes including date formatting.
 */
public abstract class StockData {

    /**
     * Provide a single SimpleDateFormat for consistency
     * and to avoid duplicated code.
     */
    protected SimpleDateFormat simpleDateFormat;

    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * Base constructor for StockData classes.
     * Initialize member data that is shared with sub classes.
     */
    public StockData() {
        simpleDateFormat = new SimpleDateFormat(dateFormat);
    }

}
