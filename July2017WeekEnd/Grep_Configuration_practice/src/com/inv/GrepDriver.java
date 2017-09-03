package com.inv;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class GrepDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		for (int i = 0; i < arg0.length; i++) {
			System.out.println("+++ IN RUN method arg0["+i+"]=="+arg0[i]);
		}
		//IMP 
		Configuration conf = this.getConf();
		
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(GrepDriver.class);
		job.setMapperClass(GrepMapper.class);
		
		job.setNumReduceTasks(0);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		return job.waitForCompletion(true)?0:1;
		
	}
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < args.length; i++) {
			System.out.println("+++ IN MAIN method args["+i+"]=="+args[i]);
		}
		int res=ToolRunner.run(new GrepDriver(), args);
		System.exit(res);
	}

}