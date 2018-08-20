require 'sinatra/base'
require_relative 'scrubber'

class App < Sinatra::Base
	get '/' do
		'Made for Persista by Sahil Agarwal'
	end

	post '/scrub' do
		if params[:file]
			content_type :json
			scrubber = Scrubber.new
			tempfile = params[:file][:tempfile]
			data = tempfile.read.gsub(/\r\n?/, "\n")
			data.each_line do |line|
				scrubber.scrub_data(line)
			end
			response = scrubber.get_response
			response
		else 
			status 400
			body "No file found."
		end
	end

	run! if app_file == $0
end
