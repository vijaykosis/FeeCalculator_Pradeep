import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.client.feecalculator.processor.ProcessTransaction;
import com.client.feecalculator.transaction.ProcessedTransactionData;
import com.client.feecalculator.transaction.Transaction;


public class ProcessTransactionTest {
	
	private ProcessTransaction processTransaction = new ProcessTransaction();
	private List<Transaction> transactions = new ArrayList<Transaction>();
	@Before
	public void setup(){
		Transaction transaction1 = new Transaction();
		transaction1.setClientId("GS");
		transaction1.setMarketValue(101);
		transaction1.setPriorityFlag(true);
		transaction1.setSecurityId("ICICI");
		transaction1.setTransactionDate("02/16/2016");
		transaction1.setTransactionId("ABCD");
		transaction1.setTransactionType("BUY");
		

		Transaction transaction2 = new Transaction();
		transaction2.setClientId("GS");
		transaction2.setMarketValue(102);
		transaction2.setPriorityFlag(true);
		transaction2.setSecurityId("ICICI");
		transaction2.setTransactionDate("02/16/2016");
		transaction2.setTransactionId("ABCD");
		transaction2.setTransactionType("SELL");
		
		Transaction transaction3 = new Transaction();
		transaction3.setClientId("GS");
		transaction3.setMarketValue(102);
		transaction3.setPriorityFlag(true);
		transaction3.setSecurityId("ABC");
		transaction3.setTransactionDate("02/15/2016");
		transaction3.setTransactionId("ABCD");
		transaction3.setTransactionType("SELL");
		
		Transaction transaction4 = new Transaction();
		transaction4.setClientId("GS");
		transaction4.setMarketValue(102);
		transaction4.setPriorityFlag(false);
		transaction4.setSecurityId("ABC");
		transaction4.setTransactionDate("02/10/2016");
		transaction4.setTransactionId("ABCD");
		transaction4.setTransactionType("SELL");	
		
		Transaction transaction5 = new Transaction();
		transaction5.setClientId("GS");
		transaction5.setMarketValue(102);
		transaction5.setPriorityFlag(false);
		transaction5.setSecurityId("ABC");
		transaction5.setTransactionDate("02/11/2016");
		transaction5.setTransactionId("ABCD");
		transaction5.setTransactionType("BUY");

		transactions.add(transaction1);
		transactions.add(transaction2);
		transactions.add(transaction3);
		transactions.add(transaction4);
		transactions.add(transaction5);
		
	}

	// Test Case for Intraday
	@Test
	public void processTransactionForIntradayTransactionTest() {
		
		ProcessTransaction processTransaction = new ProcessTransaction();
		List<ProcessedTransactionData> processedData=processTransaction.processTransactions(transactions);
		assertSame(processedData.get(0).getProcessingFee(), "$10");
		assertSame(processedData.get(1).getProcessingFee(), "$10");
	}
	
	// Test Case for High Priority
	@Test
	public void processTransactionForHighPriorityTransactionTest() {
		
		ProcessTransaction processTransaction = new ProcessTransaction();
		List<ProcessedTransactionData> processedData=processTransaction.processTransactions(transactions);
		assertSame(processedData.get(2).getProcessingFee(), "$500");
	}
	
	// Test Case for Normal Buy
	@Test
	public void processTransactionForNornmalBuyTransactionTest() {
		
		ProcessTransaction processTransaction = new ProcessTransaction();
		List<ProcessedTransactionData> processedData=processTransaction.processTransactions(transactions);
		assertSame(processedData.get(3).getProcessingFee(), "$100");
	}
	
	// Test Case for Normal Sell
	@Test
	public void processTransactionForNormalSellTransactionTest() {
		
		ProcessTransaction processTransaction = new ProcessTransaction();
		List<ProcessedTransactionData> processedData=processTransaction.processTransactions(transactions);
		assertSame(processedData.get(4).getProcessingFee(), "$50");
	}
	
}
