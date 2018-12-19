class MiscellaneousController < ApplicationController
  skip_before_filter :authenticate_user!, only: [:register, :forgot_password]
  def pricing_tables
  end

  def invoice
  end

  def login
    @simulate_no_user = true
  end

  def register
    @simulate_no_user = true
  end

  def forgot_password
    @simulate_no_user = true
  end

  def locked_screen
    @simulate_no_user = true
    @lock_screen = true
  end

  def error_404
  end

  def error_500
  end

  def blank_page
  end
end
