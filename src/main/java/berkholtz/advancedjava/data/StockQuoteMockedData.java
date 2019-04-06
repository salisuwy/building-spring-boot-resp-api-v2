package berkholtz.advancedjava.data;

import berkholtz.advancedjava.exception.NewParseException;
import berkholtz.advancedjava.model.StockQuote;
import berkholtz.advancedjava.util.Interval;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StockQuoteMockedData {
    //list of stockQuote posts
    private List<StockQuote> stockQuotes;

    private static StockQuoteMockedData instance = null;
    public static StockQuoteMockedData getInstance() throws NewParseException {
         if(instance == null){
             try {
                 instance = new StockQuoteMockedData();
             } catch (ParseException e) {
                 String message = e.getMessage();
                 throw new NewParseException("Could not parse request." + message, e);
             }
         }
         return instance;
    }


    public StockQuoteMockedData() throws ParseException {
        stockQuotes = new ArrayList<StockQuote>();
        stockQuotes.add(new StockQuote(new BigDecimal("100.00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2001-01-01 10:00:00"), "APPL"));
        stockQuotes.add(new StockQuote(new BigDecimal("101.00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2001-01-01 11:00:00"), "APPL"));
        stockQuotes.add(new StockQuote(new BigDecimal("102.00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2001-01-01 12:00:00"), "APPL"));
        stockQuotes.add(new StockQuote(new BigDecimal("103.00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2001-01-01 13:00:00"), "APPL"));
        stockQuotes.add(new StockQuote(new BigDecimal("104.00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2001-01-02 10:00:00"), "APPL"));
        stockQuotes.add(new StockQuote(new BigDecimal("105.00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2001-02-01 10:00:00"), "APPL"));

    }

    // return all stockQuotes
    public List<StockQuote> fetchStockQuotes() {
        return stockQuotes;
    }

    // return stockQuote by symbol
    public StockQuote getStockQuoteBySymbol(String symbol) {
        for(StockQuote b: stockQuotes) {
            if(b.getSymbol() == symbol) {
                return b;
            }
        }
        return null;
    }

    // search stockQuote by date
    public List<StockQuote> searchStockQuotes(Date searchDate) {
        List<StockQuote> searchedStockQuotes = new ArrayList<StockQuote>();
        for(StockQuote b: stockQuotes) {
            if(b.getDate().equals(searchDate)) {
                searchedStockQuotes.add(b);
            }
        }

        return searchedStockQuotes;
    }

    public List<StockQuote> intervalStockQuotes(String symbol, Date from, Date until, Interval interval){
        List<StockQuote> searchedStockQuotes = new ArrayList<StockQuote>();
        Calendar workingDate = Calendar.getInstance();
        workingDate.setTime(from);
        for(StockQuote b: stockQuotes) {
            if(b.getDate().after(from) && b.getDate().before(until)) {
                searchedStockQuotes.add(b);

                if (interval == Interval.MINUTE) {
                    workingDate.add(Calendar.MINUTE, 1);
                } else if (interval == Interval.HOUR) {
                    workingDate.add(Calendar.HOUR, 1);
                } else if (interval == Interval.DAY) {
                    workingDate.add(Calendar.DAY_OF_YEAR, 1);
                }
                from = workingDate.getTime();
            }
        }

        return searchedStockQuotes;

    }
    // create stockQuote
    public StockQuote createStockQuote(BigDecimal price, Date date, String symbol) {
        StockQuote newStockQuote = new StockQuote(price, date, symbol);
        stockQuotes.add(newStockQuote);
        return newStockQuote;
    }



}
