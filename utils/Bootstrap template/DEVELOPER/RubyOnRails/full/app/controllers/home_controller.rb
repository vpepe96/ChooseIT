class HomeController < ApplicationController
  def set_locale
    session[:locale] = params[:locale]
    redirect_to :back
  end
end
