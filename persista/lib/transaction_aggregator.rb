class TransactionAggregator

	@@revenues = "revenues"
	@@expenses = "expenses"
	@@funds = "funds"
	@@departments = "departments"
	@@total = "total"

	def initialize
		@data = {}
	end

	def process_transaction(transaction)
		year = transaction.get_year.to_s
		year_data = nil
		if @data.key?(year)
			year_data = @data[year]
		else
			year_data = make_year_map()
		end

		year_data = add_data(transaction, year_data)
		@data[year] = year_data
	end

	def make_year_map()
		data = {}
		data[@@revenues] = make_breakdown_map()
		data[@@expenses] = make_breakdown_map()
		data
	end

	def make_breakdown_map()
		data = {}
		data[@@funds] = {}
		data[@@departments] = {}
		data[@@total] = 0.0
		data
	end

	def add_data(transaction, year_data)
		amount = transaction.get_amount.round(2)

		# initialize fund if transaction is first fund entry
		if !(year_data[@@revenues][@@funds].key?(transaction.get_fund))
			year_data[@@expenses][@@funds][transaction.get_fund] = 0.0
			year_data[@@revenues][@@funds][transaction.get_fund] = 0.0
		end

		# initialize department if transaction is first department entry
		if !(year_data[@@revenues][@@departments].key?(transaction.get_department))
			year_data[@@expenses][@@departments][transaction.get_department] = 0.0
			year_data[@@revenues][@@departments][transaction.get_department] = 0.0
		end

		# calculate totals for the year
		if (transaction.is_revenue)
			year_data[@@revenues][@@total] = (year_data[@@revenues][@@total] + amount).round(2)
			year_data[@@revenues][@@funds][transaction.get_fund] = (year_data[@@revenues][@@funds][transaction.get_fund] + amount).round(2)
			year_data[@@revenues][@@departments][transaction.get_department] = (year_data[@@revenues][@@departments][transaction.get_department] + amount).round(2)
		else
			year_data[@@expenses][@@total] = (year_data[@@expenses][@@total] + amount).round(2)
			year_data[@@expenses][@@funds][transaction.get_fund] = (year_data[@@expenses][@@funds][transaction.get_fund] + amount).round(2)
			year_data[@@expenses][@@departments][transaction.get_department] = (year_data[@@expenses][@@departments][transaction.get_department] + amount).round(2)
		end

		year_data
	end

	def get_breakdown
		@data
	end

end