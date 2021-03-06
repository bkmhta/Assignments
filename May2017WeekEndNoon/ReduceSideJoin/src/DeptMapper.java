import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DeptMapper extends Mapper<LongWritable, Text, Text, Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
			//001,hadoop extract deptid
			String deptid=value.toString().split(",")[0];
			String deptname=value.toString().split(",")[1];
			
			context.write(new Text(deptid+"_dept"), new Text(deptname));
		
	
	
	}

}
