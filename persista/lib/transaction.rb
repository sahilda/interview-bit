class Transaction

	def initialize(line)
		split = line.split(",")
		@year = split[0].to_i
		@month = split[1].to_i
		@fund_id = split[2].to_i
		@department_id = split[3].to_i
		@fund_name = split[4]
		@department_name = split[5]
		@amount = split[6].to_f
	end

	def get_object_array
		[@year, @month, @fund_id, @department_id, @fund_name, @department_name, @amount]
	end

	def get_year
		@year
	end

	def get_fund
		@fund_name
	end

	def get_department
		@department_name
	end

	def get_amount
		@amount
	end

	def is_revenue
		@amount > 0
	end

end