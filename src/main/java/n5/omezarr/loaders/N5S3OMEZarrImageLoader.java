/*
 * #%L
 * BigDataViewer core classes with minimal dependencies
 * %%
 * Copyright (C) 2012 - 2016 Tobias Pietzsch, Stephan Saalfeld, Stephan Preibisch,
 * Jean-Yves Tinevez, HongKee Moon, Johannes Schindelin, Curtis Rueden, John Bogovic
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */
package n5.omezarr.loaders;

import com.amazonaws.services.s3.AmazonS3;
import de.embl.cba.tables.S3Utils;
import mpicbg.spim.data.generic.sequence.AbstractSequenceDescription;
import n5.omezarr.readers.N5S3ZarrReader;

import java.io.IOException;
import java.util.HashMap;

public class N5S3OMEZarrImageLoader extends N5OMEZarrImageLoader
{
	private final String serviceEndpoint;
	private final String signingRegion;
	private final String bucketName;
	private final String key;
	private static HashMap<String, Integer> axesMap;

	static class  N5S3ZarrReaderCreator
	{
		public N5S3ZarrReader create(String serviceEndpoint, String signingRegion, String bucketName, String key, String dimensionSeparator ) throws IOException
		{
			final AmazonS3 s3 = S3Utils.getS3Client( serviceEndpoint, signingRegion, bucketName );
			N5S3ZarrReader reader = new N5S3ZarrReader( s3, serviceEndpoint, bucketName, key, dimensionSeparator );
			axesMap = reader.getAxesMap();
			return reader;
		}
	}

	// sequenceDescription has been read from xml
	public N5S3OMEZarrImageLoader( String serviceEndpoint, String signingRegion, String bucketName, String key, String dimensionSeparator, AbstractSequenceDescription< ?, ?, ? > sequenceDescription ) throws IOException
	{
		super(  new N5S3ZarrReaderCreator().create( serviceEndpoint, signingRegion, bucketName, key, dimensionSeparator ), sequenceDescription);
		this.serviceEndpoint = serviceEndpoint;
		this.signingRegion = signingRegion;
		this.bucketName = bucketName;
		this.key = key;
	}

	public N5S3OMEZarrImageLoader(String serviceEndpoint, String signingRegion, String bucketName, String key, String dimensionSeparator, HashMap<String, Integer> axes) throws IOException
	{
		super( new N5S3ZarrReaderCreator().create( serviceEndpoint, signingRegion, bucketName, key, dimensionSeparator), axesMap);
		this.serviceEndpoint = serviceEndpoint;
		this.signingRegion = signingRegion;
		this.bucketName = bucketName;
		this.key = key;
	}


	public String getServiceEndpoint()
	{
		return serviceEndpoint;
	}

	public String getSigningRegion()
	{
		return signingRegion;
	}

	public String getBucketName()
	{
		return bucketName;
	}

	public String getKey()
	{
		return key;
	}
}
