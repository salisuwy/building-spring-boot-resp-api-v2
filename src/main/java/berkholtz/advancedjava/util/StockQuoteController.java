package berkholtz.advancedjava.util;

import berkholtz.advancedjava.data.StockQuoteMockedData;
import berkholtz.advancedjava.exception.NewParseException;
import berkholtz.advancedjava.model.StockQuote;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class StockQuoteController {

    StockQuoteMockedData stockQuoteMockedData = StockQuoteMockedData.getInstance();

    public StockQuoteController() throws NewParseException {
    }

    @GetMapping("/stockQuote")
    public List<StockQuote> index(){
        return stockQuoteMockedData.fetchStockQuotes();
    }

    @GetMapping("/stockQuote/{symbol}")
    public StockQuote show(@PathVariable String symbol){
        String stockQuoteSymbol = symbol;
        return stockQuoteMockedData.getStockQuoteBySymbol(stockQuoteSymbol);
    }

    //@GetMapping("/stockQuote/interval")
    //public List<StockQuote> show(@RequestBody String, Date, Date, Interval){
    //    String searchTerm = body.get("text");
    //    return stockQuoteMockedData.intervalStockQuotes(searchTerm);
    //}




}