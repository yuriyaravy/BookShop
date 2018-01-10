package backend.src.com.senla.bookshop.utils.csvworker;

public class PathStorage {
	
	private String csvBookFile = "src/by/home/book/file/CSVFiles/books.csv";
	private String csvOrderFile = "src/by/home/book/file/CSVFiles/orders.csv";
	private String csvRequestFile = "src/by/home/book/file/CSVFiles/requests.csv";
	
	public String getCsvBookFile() {
		return csvBookFile;
	}
	public void setCsvBookFile(String csvBookFile) {
		this.csvBookFile = csvBookFile;
	}
	public String getCsvOrderFile() {
		return csvOrderFile;
	}
	public void setCsvOrderFile(String csvOrderFile) {
		this.csvOrderFile = csvOrderFile;
	}
	public String getCsvRequestFile() {
		return csvRequestFile;
	}
	public void setCsvRequestFile(String csvRequestFile) {
		this.csvRequestFile = csvRequestFile;
	}
}
