package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q1Mapper extends Mapper<LongWritable, Text, FloatWritable, Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, FloatWritable, Text>.Context context)
			throws IOException, InterruptedException {
		
		String[] record=value.toString().split("@");
		//1@4.0@Toy Story (1995)
		context.write(new FloatWritable(Float.parseFloat(record[1])*-1), value);
		
	}

}
