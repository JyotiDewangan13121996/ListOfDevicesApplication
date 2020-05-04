package com.app.services;

import java.util.Arrays;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.classmate.util.ClassStack;

public class AvroDeserializer<T extends SpecificRecordBase> implements Deserializer<T>
{

	private static final Logger LOGGER =LoggerFactory.getLogger(AvroDeserializer.class);

	
	public AvroDeserializer() 
	{
		System.out.println("in avro deserializer constructor");
	}
	
	
	
	public  Class<T> targetType = null;
	
	 public AvroDeserializer(Class<T> targetType)
	{
		this.targetType = targetType ;
	}
	
	 
	 @Override
	public void close() 
	 {
		//No operation
	}
	
	 
	 @Override
	public void configure(Map<String, ?> arg0, boolean arg1) 
	 {
		// No Operation
	}
	 
	
	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(String topic, byte[] data) 
	{
	
		try 
		{
		
			T result = null ;
			
			if(data != null)
			{
				LOGGER.debug("data='{}'",DatatypeConverter.printHexBinary(data));
			    
				DatumReader<GenericRecord> datumReader = new SpecificDatumReader<>(targetType.newInstance().getSchema());
				
				Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);
				
				result = (T) datumReader.read(null, decoder);
				
				LOGGER.debug("deserialized data='{}'", result);
				
				
			}
			
			return result;
			
			
		} catch (Exception e) 
		{
			throw new SerializationException(
				"Can't deserialize data '" + Arrays.toString(data) + " 'from topic'" + topic + "'" ,e);
		}
		
		
	
	}
	
	
	
}