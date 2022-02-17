//Maximus Nie
//2/17/2022
//CS245 Lab 3: Sorting and Performance

public class Performance {
	private final int datasetSize;
	private long firstAlgoStartTime;
	private long firstAlgoEndTime;
	private long secondAlgoStartTime;
	private long secondAlgoEndTime;
	private final int iterations;

	public Performance(int datasetSize, int iterations){
		this.datasetSize = datasetSize;
		this.iterations = iterations;
	}

	public void setFirstAlgoStartTime(long firstAlgoStartTime) {
		this.firstAlgoStartTime = firstAlgoStartTime;
	}

	public void setFirstAlgoEndTime(long firstAlgoEndTime) {
		this.firstAlgoEndTime = firstAlgoEndTime;
	}

	public void setSecondAlgoStartTime(long secondAlgoStartTime) {
		this.secondAlgoStartTime = secondAlgoStartTime;
	}

	public void setSecondAlgoEndTime(long secondAlgoEndTime) {
		this.secondAlgoEndTime = secondAlgoEndTime;
	}

	public long getFirstAlgoStartTime() {
		return firstAlgoStartTime;
	}

	public long getFirstAlgoEndTime() {
	  return firstAlgoEndTime;
	}

	public long getSecondAlgoStartTime() {
		return secondAlgoStartTime;
	}

	public long getSecondAlgoEndTime() {
		return secondAlgoEndTime;
	}
	
	public int getIterations() {
		return iterations;
	}

	public int getDatasetSize() {
		return datasetSize;
	}

	public long getFirstAlgoPerformance() {
		return (this.firstAlgoEndTime - this.firstAlgoStartTime) / this.iterations;
	}

	public long getSecondAlgoPerformance() {
	  return (this.secondAlgoEndTime - this.secondAlgoStartTime) / this.iterations;
	}

  @Override
  	public String toString() {
//    return "Performance{" +
//            "datasetSize=" + datasetSize +
//            "iterations=" + iterations +
//            ", firstAlgoStartTime=" + firstAlgoStartTime +
//            ", firstAlgoEndTime=" + firstAlgoEndTime +
//            ", secondAlgoStartTime=" + secondAlgoStartTime +
//            ", secondAlgoEndTime=" + secondAlgoEndTime +
//            '}';
	  return "For dataset of " + datasetSize + " numbers" +//System.getProperty("line.separator") +
            " firstAlgoPerformance=" + this.getFirstAlgoPerformance() + "ms" +
            ", secondAlgoPerformance=" + this.getSecondAlgoPerformance() + "ms" ;
  }
}