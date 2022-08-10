package com.it_academy.tests.ui;

import com.it_academy.tests.ui.local_parallel_browsers.OnlinerCatalogLocalParallelTest;
import com.it_academy.tests.ui.remote_parallel_browsers.OnlinerCatalogRemoteParallelTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses( { OnlinerCatalogRemoteParallelTest.class,
        OnlinerCatalogLocalParallelTest.class} )

public class SuiteLocalRemoteParallelExecution {
}
