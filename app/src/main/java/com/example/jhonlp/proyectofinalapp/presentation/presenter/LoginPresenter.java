package com.example.jhonlp.proyectofinalapp.presentation.presenter;

import android.util.Log;

import com.example.jhonlp.proyectofinalapp.domain.model.User;
import com.example.jhonlp.proyectofinalapp.domain.useCase.ILocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.domain.useCase.impl.LocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.domain.useCase.impl.UserUseCase;
import com.example.jhonlp.proyectofinalapp.helpers.Callback;
import com.example.jhonlp.proyectofinalapp.utilities.Constant;


public class LoginPresenter implements LoginContract.UserActionListener {

    private LoginContract.View view;
    private ILocalDataUseCase localDataUseCase;
    private UserUseCase userUseCase;


    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.localDataUseCase = new LocalDataUseCase();
        this.userUseCase = new UserUseCase();


    }

    @Override
    public void onLogin(final String email, String password, final boolean remember) {
        view.showProgress();
        userUseCase.login(email, password, remember, new Callback<User>() {
            @Override
            public void success(User result) {
                view.hidePRogress();
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.hidePRogress();
                view.showMessageError(error);
            }
        });
    }

    @Override
    public void loadTorneoDetalle() {
        /*torneoDetalleRestUseCase.getAll(new Callback<List<TorneoDetalle>>() {
            @Override
            public void success(List<TorneoDetalle> result) {
                for (TorneoDetalle torneoDetalle : result)
                {Log.d(StartPresenter.class.toString(), "TorneoDetalle was saved: " + result.toString());

                    }
                }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
*/

    }

    @Override
    public void loadCountries() {
 /*       countryRestUseCase.getAll(new Callback<List<Country>>() {
            @Override
            public void success(List<Country> result) {
                for (Country country : result)
                {
                    countryUseCase.insert(country, new Callback<Country>() {
                        @Override
                        public void success(Country result) {
                            Log.d(StartPresenter.class.toString(), "Country was saved: " + result.getName());
                        }

                        @Override
                        public void error(Exception error) {
                            view.showMessageError(error);
                        }
                    });
                }
            }
            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });*/
    }

    @Override
    public void loadLeagues() {
/*        leagueRestUseCase.getAll(new Callback<List<League>>() {
            @Override
            public void success(List<League> result) {
                for (League league : result) {
                    leagueUseCase.insert(league, new Callback<League>() {
                        @Override
                        public void success(League result) {
                            Log.d(StartPresenter.class.toString(), "League was saved: " + result.getName());
                        }

                        @Override
                        public void error(Exception error) {
                            view.showMessageError(error);
                        }
                    });
                }
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });*/
    }

    @Override
    public void loadTeams() {/*
        teamRestUseCase.getAll(new Callback<List<Team>>() {
            @Override
            public void success(List<Team> result) {
                for (Team team : result) {

                    teamUseCase.insert(team, new Callback<Team>() {
                        @Override
                        public void success(Team result) {
                            Log.d(StartPresenter.class.toString(), "Team was saved:" + result.getName());
                        }

                        @Override
                        public void error(Exception error) {
                            view.showMessageError(error);
                        }
                    });
                }
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });*/
    }


    @Override
    public void configure() {

        try {

            String email = localDataUseCase.getData(Constant.SHARED_PREF_EMAIL, String.class);
            if (email != null) {
                view.showRememberedUser(email);
            }
        } catch (Exception ex) {
            view.showMessageError(ex);
        }
    }
}
