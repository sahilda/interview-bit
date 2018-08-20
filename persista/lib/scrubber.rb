require_relative 'transaction'
require_relative 'transaction_aggregator'
require 'json'

class Scrubber

	def initialize
		@lines_scrubbed = 0
		@response = {}
		@parsed_data = []
		@aggregator = TransactionAggregator.new
	end

	def scrub_data(line)
		if !(@lines_scrubbed == 0 && line.include?("Year"))
			transaction = Transaction.new(line)
			@parsed_data << transaction.get_object_array
			@aggregator.process_transaction(transaction)
		end
		@lines_scrubbed += 1
	end 

	def get_response
		@response["rows_parsed"] = @parsed_data
		@response["aggregations"] = @aggregator.get_breakdown
		@response.to_json
	end

end