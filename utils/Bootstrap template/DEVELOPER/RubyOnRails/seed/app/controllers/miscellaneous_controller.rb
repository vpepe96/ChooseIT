class MiscellaneousController < ApplicationController
  skip_before_filter :authenticate_user!, only: [:register, :forgot_password]

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

  def blank_page
  end
end
